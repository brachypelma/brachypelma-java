package com.github.arachnidium.core.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import com.github.arachnidium.core.interfaces.IExtendedWindow;
import com.github.arachnidium.core.interfaces.IHasHandle;
import com.github.arachnidium.util.configuration.interfaces.IConfigurationWrapper;

/**
 *@link{IWindowListener} general implementor
 * Listens to browser window events
 */
@Aspect
class AspectWindow extends AbstractAspect {

	private final DefaultWindowListener defaultWindowListener;
	
	public AspectWindow(IConfigurationWrapper configurationWrapper) {
		super(configurationWrapper);
		defaultWindowListener = new DefaultWindowListener(configurationWrapper);
	}

    @Before("execution(* com.github.arachnidium.core.interfaces.ISwitchesToItself.switchToMe(..))")
	public void beforeIsSwitchedOn(JoinPoint joinPoint) throws Throwable{
    	try {
			IHasHandle handle = (IHasHandle) joinPoint.getTarget();
			defaultWindowListener.beforeIsSwitchedOn(handle);
    	}catch(Throwable t){
			throw getRootCause(t);
		}
	}

    @Before("execution(* com.github.arachnidium.core.interfaces.IExtendedWindow.close(..))")
	public void beforeWindowIsClosed(JoinPoint joinPoint) throws Throwable{
    	try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			defaultWindowListener.beforeWindowIsClosed(window);
    	}catch(Throwable t){
			throw getRootCause(t);
		}
	}

    @Before("execution(* org.openqa.selenium.WebDriver.Window.maximize(..))")
	public void beforeWindowIsMaximized(JoinPoint joinPoint) throws Throwable{
    	try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			defaultWindowListener.beforeWindowIsMaximized(window);
    	}catch(Throwable t){
			throw getRootCause(t);
		}
	}

    @Before("execution(* org.openqa.selenium.WebDriver.Window.setPosition(..))")
	public void beforeWindowIsMoved(JoinPoint joinPoint) throws Throwable{
    	try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			Point point = (Point) joinPoint.getArgs()[0];
			defaultWindowListener.beforeWindowIsMoved(window, point);
    	}catch(Throwable t){
			throw getRootCause(t);
		}
	}

    @Before("execution(* org.openqa.selenium.WebDriver.Navigation.refresh(..))")
	public void beforeWindowIsRefreshed(JoinPoint joinPoint) throws Throwable{
    	try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			defaultWindowListener.beforeWindowIsRefreshed(window);
    	}catch(Throwable t){
			throw getRootCause(t);
		}
	}

    @Before("execution(* org.openqa.selenium.WebDriver.Window.setSize(..))")
	public void beforeWindowIsResized(JoinPoint joinPoint) throws Throwable{
    	try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			Dimension dimension = (Dimension) joinPoint.getArgs()[0];
			defaultWindowListener.beforeWindowIsResized(window, dimension);
    	}catch(Throwable t){
			throw getRootCause(t);
		}
	}
	
	@After("execution(* com.github.arachnidium.core.interfaces.ISwitchesToItself.switchToMe(..))")
	public void whenIsSwitchedOn(JoinPoint joinPoint) throws Throwable{
		try {
			IHasHandle handle = (IHasHandle) joinPoint.getTarget();
			defaultWindowListener.whenIsSwitchedOn(handle);
		}catch(Throwable t){
			throw getRootCause(t);
		}
	}

	@After("execution(* com.github.arachnidium.core.interfaces.IHasHandle.whenIsCreated(..))")
	public void whenNewHandleIsAppeared(JoinPoint joinPoint) throws Throwable{
		try {
			IHasHandle handle = (IHasHandle) joinPoint.getTarget();
			defaultWindowListener.whenNewHandleIsAppeared(handle);
		}catch(Throwable t){
			throw getRootCause(t);
		}
	}


	@After("execution(* com.github.arachnidium.core.interfaces.IExtendedWindow.close(..))")
	public void whenWindowIsClosed(JoinPoint joinPoint) throws Throwable{
		try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			defaultWindowListener.whenWindowIsClosed(window);
		}catch(Throwable t){
			throw getRootCause(t);
		}
	}

	@After("execution(* org.openqa.selenium.WebDriver.Window.maximize(..))")
	public void whenWindowIsMaximized(JoinPoint joinPoint) throws Throwable{
		try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			defaultWindowListener.whenWindowIsMaximized(window);
		}catch(Throwable t){
			throw getRootCause(t);
		}
	}
	
	@After("execution(* org.openqa.selenium.WebDriver.Window.setPosition(..))")
	public void whenWindowIsMoved(JoinPoint joinPoint) throws Throwable{
		try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			Point point = (Point) joinPoint.getArgs()[0];
			defaultWindowListener.whenWindowIsMoved(window, point);
		}catch(Throwable t){
			throw getRootCause(t);
		}
	}

	@After("execution(* org.openqa.selenium.WebDriver.Navigation.refresh(..))")
	public void whenWindowIsRefreshed(JoinPoint joinPoint) throws Throwable{
		try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			defaultWindowListener.whenWindowIsRefreshed(window);
		}catch(Throwable t){
			throw getRootCause(t);
		}
	}

	@After("execution(* org.openqa.selenium.WebDriver.Window.setSize(..))")
	public void whenWindowIsResized(JoinPoint joinPoint) throws Throwable{
		try {
			IExtendedWindow window = (IExtendedWindow) joinPoint.getTarget();
			Dimension dimension = (Dimension) joinPoint.getArgs()[0];
			defaultWindowListener.whenWindowIsResized(window, dimension);
		}catch(Throwable t){
			throw getRootCause(t);
		}
	}

	/**
	 * @see com.github.arachnidium.core.bean.AbstractAspect#doAround(org.aspectj.lang.ProceedingJoinPoint)
	 */
	@Override
	@Around("execution(* com.github.arachnidium.core.interfaces.IExtendedWindow.*(..)) || "
			+ "execution(* com.github.arachnidium.core.interfaces.IHasHandle.*(..)) || "
			+ "execution(* com.github.arachnidium.core.interfaces.ISwitchesToItself.*(..)) || " +
			"execution(* org.openqa.selenium.WebDriver.Window.*(..))")
	public Object doAround(ProceedingJoinPoint point) throws Throwable {
		Object result = null;
		try {
			result = point.proceed();
		} catch (Exception e) {
			throw getRootCause(e);
		}
		return result;
	}

}
