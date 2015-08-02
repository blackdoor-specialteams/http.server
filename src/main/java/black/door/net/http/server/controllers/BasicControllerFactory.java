package black.door.net.http.server.controllers;

import black.door.net.http.server.Controller;

import static black.door.util.DBP.*;

/**
 * This abomination created by nfischer on 7/9/2015.
 */
public class BasicControllerFactory implements Controller.ControllerFactory{

	private Class<? extends Controller> controllerClass;

	public BasicControllerFactory(Class<? extends Controller> controllerClass){
		this.controllerClass = controllerClass;
	}

	@Override
	public Controller manufacture() {
		Controller controller = null;
		try {
			controller = controllerClass.newInstance();
		} catch (InstantiationException e) {
			printException(e);
		} catch (IllegalAccessException e) {
			printException(e);
		}
		return controller;
	}

	/**
	 * @param controllerClass
	 * @return a ControllerFactory which creates instances of controllerClass
	 */
	public static Controller.ControllerFactory getInstance(Class<? extends Controller> controllerClass){
		return () -> {
			try {
				return controllerClass.newInstance();
			} catch (InstantiationException e) {
				printException(e);
			} catch (IllegalAccessException e) {
				printException(e);
			}
			return null;
		};
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BasicControllerFactory that = (BasicControllerFactory) o;

		return !(controllerClass != null ? !controllerClass.equals(that.controllerClass) : that.controllerClass != null);

	}

	@Override
	public int hashCode() {
		return controllerClass != null ? controllerClass.hashCode() : 0;
	}
}
