package cal;

/**
 * When there is error in ParserFactory, NullParser will be created and returned
 * to indicate there is problem during creation of Parser.
 * 
 * This is a <ConcreteProduct> that should be created by ParserFactory<Factory>
 */
public class NullParser implements Parser {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cal.Parser#read(java.lang.String)
	 * @return false to indicate error has happened
	 */
	@Override
	public boolean read(String inputString) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cal.Parser#execute()
	 */
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return "Improper input format.";
	}

}
