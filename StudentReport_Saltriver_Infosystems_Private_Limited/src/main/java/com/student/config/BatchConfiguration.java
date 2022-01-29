package com.student.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.student.model.Student;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	DataSource dataSource;

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Bean
	public FlatFileItemReader<Student> reader() {
		FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("student.csv"));
		reader.setLineMapper(getLineMapper());
		reader.setLinesToSkip(1);
		return reader;
	}

	private LineMapper<Student> getLineMapper() {

		DefaultLineMapper<Student> lineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setNames(new String[] { "Name", "Roll No", "College", "Physics", "Chemistry", "Biology", "Maths",
				"English", "Computers" });
		lineTokenizer.setIncludedFields(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });

		BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();

		fieldSetMapper.setTargetType(Student.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}

	@Bean
	public ItemProcess processor() {
		return new ItemProcess();
	}

	@Bean
	public JdbcBatchItemWriter<Student> Writter() {
		JdbcBatchItemWriter<Student> writer = new JdbcBatchItemWriter<>();

		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		writer.setSql(
"insert into student(name,roll_no,college,physics,chemistry,biology,maths,english,computers) values(:name,:roll_no,:college,:physics,:chemistry,:biology,:maths,:english,:computers) ");
		writer.setDataSource(this.dataSource);

		return writer;
	}

	@Bean
	public Job importUserJob() {
		return this.jobBuilderFactory.get("STUDENT-IMPORT-JOB").incrementer(new RunIdIncrementer()).flow(step1()).end()
				.build();

	}
	
	@Bean
	public Step step1() {
		
		return this.stepBuilderFactory.get("step1")
				.<Student,Student>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(Writter()).build();
	}
	
}
