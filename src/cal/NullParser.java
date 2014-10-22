package cal;

/**
 * When there is error in ParserFactory, NullParser will be created and returned
 * to indicate there is problem during creation of Parser.
 * 
 * This is a <ConcreteProduct> that should be created by ParserFactory<Factory>
 */
public class NullParser extends Parser {

    	public NullParser(String inputString)
    	{
    	    super(inputString);
    	}
    	
	/**
	 * (non-Javadoc)
	 * 
	 * @see cal.Parser#read(java.lang.String)
	 * @return void
	 */
	@Override
	public void read(String inputString) {
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cal.Parser#execute()
	 */
	@Override
	public String execute() {
		return "Improper input format.";
	}

}
