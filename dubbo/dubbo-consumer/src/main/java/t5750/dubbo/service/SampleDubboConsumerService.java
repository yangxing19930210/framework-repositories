package t5750.dubbo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import t5750.dubbo.domain.User;

import com.alibaba.dubbo.config.annotation.Reference;

@Component
public class SampleDubboConsumerService {
	@Reference(version = "1.0.0")
	private SampleService sampleService;

	public String printHello() {
		String hello = sampleService.sayHello("tom");
		System.out.println(hello);
		return hello;
	}

	public List<User> printUsers() {
		List<User> list = sampleService.getUsers();
		for (User user : list) {
			System.out.println("name=" + user.getName() + ", age="
					+ user.getAge() + ", sex=" + user.getSex());
		}
		return list;
	}
}