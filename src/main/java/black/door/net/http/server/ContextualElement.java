package black.door.net.http.server;

/**
 * This abomination created by nfischer on 7/9/2015.
 */
interface ContextualElement{

	/**
	 *
	 * @return The context of this http transaction, the request and response can be obtainted here
	 */
	public HttpTransactionContext getContext();
}
