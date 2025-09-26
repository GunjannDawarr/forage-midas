// package com.jpmc.midascore;
//
// import org.junit.jupiter.api.Test;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.test.context.SpringBootTest;
//
// @SpringBootTest
// class TaskOneTests {
//     static final Logger logger = LoggerFactory.getLogger(TaskOneTests.class);
//
//     @Test
//     void task_one_verifier() throws InterruptedException {
//         Thread.sleep(2000);
//         logger.info("----------------------------------------------------------");
//         logger.info("----------------------------------------------------------");
//         logger.info("----------------------------------------------------------");
//         logger.info("Congrats! It looks like your application booted without issue");
//         logger.info("submit the following output to complete the task (include begin and end output denotations)");
//         StringBuilder output = new StringBuilder("\n").append("---begin output ---").append("\n");
//         for (int i = 0; i < 10; i++) {
//             output.append(String.valueOf((int) Math.floor(Math.pow(i, i))));
//         }
//         output.append("\n").append("---end output ---");
//         logger.info(output.toString());
//
//     }
//
// }

package com.jpmc.midascore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = MidasCoreApplication.class)
@TestPropertySource(properties = {
        "general.kafka-topic=test-topic"
})
public class TaskOneTests {

    @Test
    public void task_one_verifier() throws InterruptedException {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int result = (int) Math.floor(Math.pow(i, i));
            output.append(result).append(", ");
        }
        System.out.println("--- BEGIN TASK ONE OUTPUT ---");
        System.out.println(output);
        System.out.println("--- END TASK ONE OUTPUT ---");
    }
}
