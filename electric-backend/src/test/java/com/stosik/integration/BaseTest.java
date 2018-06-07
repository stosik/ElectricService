package com.stosik.integration;

import com.stosik.electric.ElectricServiceApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
                classes = ElectricServiceApplication.class)
@RunWith(SpringRunner.class)
@SqlGroup({
              @Sql(scripts = "/database/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD),
          })
public abstract class BaseTest
{

}