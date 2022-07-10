package com.iris.irisback.configurations;
//
// import com.iris.irisback.model.Machine;
// import org.springframework.batch.core.JobParametersValidator;
// import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
// import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
// import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
// import org.springframework.batch.core.job.CompositeJobParametersValidator;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import java.util.Collections;
//
// @EnableBatchProcessing
// @Configuration
// public class BatchConfiguration {
//
//  public final JobBuilderFactory jobBuilderFactory;
//
//  public final StepBuilderFactory stepBuilderFactory;
//
//  public BatchConfiguration(
//          final JobBuilderFactory jobBuilderFactory, final StepBuilderFactory stepBuilderFactory)
// {
//    this.jobBuilderFactory = jobBuilderFactory;
//    this.stepBuilderFactory = stepBuilderFactory;
//  }
//
//  @Bean
//  public JobParametersValidator jobParametersValidator() {
//    return new EmployeeJobParametersValidator();
//  }
//
//  @Bean
//  public JobParametersValidator compositeJobParametersValidator() {
//    final CompositeJobParametersValidator bean = new CompositeJobParametersValidator();
//    bean.setValidators(Collections.singletonList(jobParametersValidator()));
//    return bean;
//  }
//
//  @Bean
//  public ItemProcessor<Machine, Machine> itemProcessor() {
//    return new EmployeeItemProcessor();
//  }
//
//  @Bean
//  public ItemReader<Employee> itemReader() {
//    return new EmployeeItemReader();
//  }
//
//  @Bean
//  public MongoItemWriter<Employee> writer(final MongoTemplate mongoTemplate) {
//    return new MongoItemWriterBuilder<Employee>()
//        .template(mongoTemplate)
//        .collection("employee")
//        .build();
//  }
//
//  /**
//   * Declaration step
//   *
//   * @return {@link Step}
//   */
//  @Bean
//  public Step employeeStep(final MongoItemWriter<Employee> itemWriter) {
//    return stepBuilderFactory
//        .get("employeeStep")
//        .<Employee, Employee>chunk(50)
//        .reader(itemReader())
//        .processor(itemProcessor())
//        .writer(itemWriter)
//        .build();
//  }
//
//  /**
//   * Declaration job
//   *
//   * @param listener {@link JobCompletionListener}
//   * @return {@link Job}
//   */
//  @Bean
//  public Job employeeJob(final JobCompletionListener listener, final Step employeeStep) {
//    return jobBuilderFactory
//        .get("employeeJob")
//        .incrementer(new RunIdIncrementer())
//        .listener(listener)
//        .flow(employeeStep)
//        .end()
//        .validator(compositeJobParametersValidator())
//        .build();
//  }
// }
