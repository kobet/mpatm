package com.example.mpatm;

import com.example.mpatm.mapper.BatchOperationDetailMapper;
import com.example.mpatm.mapper.BatchOperationMapper;
import com.example.mpatm.model.BatchOperation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpatmApplicationTests {

    @Autowired
    private BatchOperationMapper batchOperationMapper;

    @Autowired
    private BatchOperationDetailMapper batchOperationDetailMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    //@Rollback
    public void insert() {
        System.out.println("===========================init end=================");
        int batchIndex = batchOperationMapper.insert("test");
        for (int i = 0; i < 100000; i++) {
            batchOperationDetailMapper.insert(batchIndex, 1, UUID.randomUUID().toString());
        }
        System.out.println("===========================init end=================");
    }

    /**
     * 演示死锁
     */
    @Test
    public void DeadLock() throws Exception {
		for (int i=0;i<100;i++) {
			new Thread(() ->
					lock()
					, i + "任务线程").start();
		}

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
                lock();
//            }
//        }, "B任务线程").start();

    }
    public void lock() {
        transactionTemplate.setTimeout(60);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            /**
             * Gets called by {@code TransactionTemplate.execute} within a transactional
             * context. Does not need to care about transactions itself, although it can retrieve
             * and influence the status of the current transaction via the given status object,
             * e.g. setting rollback-only.
             * <p>A RuntimeException thrown by the callback is treated as application
             * exception that enforces a rollback. An exception gets propagated to the
             * caller of the template.
             * <p>Note when using JTA: JTA transactions only work with transactional
             * JNDI resources, so implementations need to use such resources if they
             * want transaction support.
             *
             * @param status associated transaction status
             * @see TransactionTemplate#execute
             */
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                System.out.println("===========:" + Thread.currentThread() + "启动");
                BatchOperation batchOperation = batchOperationMapper.lockById(2);
                Assert.assertNotNull(batchOperation);
                System.out.println("===========:" + batchOperation + "," + Thread.currentThread() + "锁定主表成功");
                batchOperationDetailMapper.lockByTypeAndBusinessId(1, "da6cd159-99ad-4dfb-a115-b2383f444763");
                try {
                    Thread.sleep(50000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("===========:" + Thread.currentThread() + "结束");
            }
        });

    }


}
