package ar.com.scriptorum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ar.com.scriptorum.animales.JaulaTest;
import ar.com.scriptorum.aspects.adder.AdderTest;
import ar.com.scriptorum.clonable.CloningObjectsTest;
import ar.com.scriptorum.concurrence.ForemanTest;
import ar.com.scriptorum.concurrence.Runner;
import ar.com.scriptorum.concurrence.StoreTest;
import ar.com.scriptorum.patterns.decorator.DecoratorTests;
import ar.com.scriptorum.patterns.prototype.ComplexTest;
import ar.com.scriptorum.predicates.TestBooleanPredicate;
import ar.com.scriptorum.rimas.silabeo.SilabaBuilderTest;
import ar.com.scriptorum.spring.ioc.appContextBased.IoC_Test;
import ar.com.scriptorum.state.TestClientState;
import ar.com.scriptorum.taba.dao.impl.TestCarpoolerDao;
import ar.com.scriptorum.taba.dao.impl.TestuserDao;
import ar.com.scriptorum.taba.util.PersonSwapperTest;
import ar.com.scriptorum.taba.util.SwapTest;
import ar.com.scriptorum.taba.util.documents.DocumentConfiguratorsTest;
import ar.com.scriptorum.taba.util.documents.DocumentTransitionTest;
import ar.com.scriptorum.taba.util.state.NullTestCase;
import ar.com.scriptorum.taba.util.state.StateMachineTest;
import ar.com.scriptorum.taba.util.visitor.TestModemVisitor;
import ar.com.scriptorum.util.ArrayUtilsTest;
import ar.com.scriptorum.util.SomeMethodsTest;

@RunWith(Suite.class)
@SuiteClasses({TestClientState.class, ComplexTest.class, SwapTest.class, DecoratorTests.class, JaulaTest.class, CloningObjectsTest.class, ForemanTest.class, TestBooleanPredicate.class,
	TestCarpoolerDao.class, TestuserDao.class,  PersonSwapperTest.class,DocumentConfiguratorsTest.class,
	DocumentTransitionTest.class,NullTestCase.class, StateMachineTest.class,TestModemVisitor.class,
	ArrayUtilsTest.class, SomeMethodsTest.class, AdderTest.class, SilabaBuilderTest.class,IoC_Test.class,
	Runner.class, StoreTest.class})
public class AllTests {}
