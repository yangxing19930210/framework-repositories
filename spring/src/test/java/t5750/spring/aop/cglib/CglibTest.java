package t5750.spring.aop.cglib;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.*;
import t5750.spring.aop.cglib.proxy.AuthorizationInterceptor;
import t5750.spring.aop.cglib.proxy.PersistenceServiceCallbackFilter;
import t5750.spring.aop.cglib.service.*;
import t5750.spring.aop.cglib.service.impl.*;

public class CglibTest {
	/**
	 * 4. Implementing Proxy Using cglib<br/>
	 * 4.1. Returning the Same Value
	 */
	@Test
	public void returnValue() throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PersonService.class);
		enhancer.setCallback((FixedValue) () -> "Hello T5750!");
		PersonService proxy = (PersonService) enhancer.create();
		String res = proxy.sayHello(null);
		Assert.assertEquals("Hello T5750!", res);
	}

	/**
	 * 4.2. Returning Value Depending on a Method Signature
	 */
	@Test
	public void returnSignatureValue() throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PersonService.class);
		enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
			if (method.getDeclaringClass() != Object.class
					&& method.getReturnType() == String.class) {
				return "Hello T5750!";
			} else {
				return proxy.invokeSuper(obj, args);
			}
		});
		PersonService proxy = (PersonService) enhancer.create();
		Assert.assertEquals("Hello T5750!", proxy.sayHello(null));
		int lengthOfName = proxy.lengthOfName("Mary");
		Assert.assertEquals(4, lengthOfName);
	}

	/**
	 * 5. Bean Creator
	 */
	@Test
	public void beanCreator() throws Exception {
		BeanGenerator beanGenerator = new BeanGenerator();
		beanGenerator.addProperty("name", String.class);
		Object myBean = beanGenerator.create();
		Method setter = myBean.getClass().getMethod("setName", String.class);
		setter.invoke(myBean, "some string value set by a cglib");
		Method getter = myBean.getClass().getMethod("getName");
		Assert.assertEquals("some string value set by a cglib",
				getter.invoke(myBean));
	}

	/**
	 * 6. Creating Mixin
	 */
	@Test
	public void createMixin() throws Exception {
		Mixin mixin = Mixin.create(
				new Class[] { MixinFirst.class, MixinSecond.class,
						MixinInterface.class },
				new Object[] { new MixinFirstImpl(), new MixinSecondImpl() });
		MixinInterface mixinDelegate = (MixinInterface) mixin;
		Assert.assertEquals("first behaviour", mixinDelegate.first());
		Assert.assertEquals("second behaviour", mixinDelegate.second());
	}

	/**
	 * Access the generated byte[] array directly
	 */
	@Test
	public void generateArray() throws Exception {
		Enhancer e = new Enhancer();
		e.setSuperclass(PersonService.class);
		e.setCallback((FixedValue) () -> "Hello T5750!");
		e.setStrategy(new DefaultGeneratorStrategy() {
			protected byte[] transform(byte[] b) {
				return b;
			}
		});
		PersonService obj = (PersonService) e.create();
		System.out.println(obj.sayHello(null));
	}

	/**
	 * Create a proxy using NoOp callback. The target class must have a default
	 * zero-argument constructor.
	 *
	 * @param targetClass
	 *            the super class of the proxy
	 * @return a new proxy for a target class instance
	 */
	public Object createProxy(Class targetClass) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClass);
		enhancer.setCallback(NoOp.INSTANCE);
		return enhancer.create();
	}

	/**
	 * Create a simple proxy
	 */
	@Test
	public void simpleProxy() throws Exception {
		PersistenceService persistenceService = (PersistenceServiceImpl) createProxy(
				PersistenceServiceImpl.class);
		long id = 1L;
		persistenceService.save(id, "simpleProxy");
		System.out.println(persistenceService.load(id));
	}

	/**
	 * Use a MethodInterceptor
	 */
	@Test
	public void testPersistence() throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PersistenceServiceImpl.class);
		CallbackFilter callbackFilter = new PersistenceServiceCallbackFilter();
		enhancer.setCallbackFilter(callbackFilter);
		AuthorizationService authorizationService = new AuthorizationServiceImpl();
		Callback saveCallback = new AuthorizationInterceptor(
				authorizationService);
		Callback loadCallback = NoOp.INSTANCE;
		Callback[] callbacks = new Callback[] { saveCallback, loadCallback };
		enhancer.setCallbacks(callbacks);
		PersistenceService persistenceService = (PersistenceServiceImpl) enhancer
				.create();
		long id = 1L;
		persistenceService.save(id, "testPersistence");
		System.out.println(persistenceService.load(id));
	}
}