package SmartDevice;  


public class Network implements INetwork{
	
	private final INetwork database;

    public Network(Builder builder) {
        this.database = builder.database;
    }

	public UserAccount verifyUser(int userId, int password) {
		// TODO Auto-generated method stub
		return database.verifyUser(userId, password);
	}
	
    public static class Builder {
		
		private INetwork database;
		
		public Builder database(final INetwork database)
		{
			this.database = database;
			return this;
		}
		
		public Network build() {
			return new Network(this);
		}

		
	}

}
