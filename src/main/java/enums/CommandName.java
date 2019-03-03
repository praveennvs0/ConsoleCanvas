package enums;

// stores the command names 
public enum CommandName {

    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKETFILL("B"),
    QUIT("Q");
    
    private String commandName ;
    
    CommandName(String commandName) {
        this.commandName = commandName ;
    }

    public String getCommandName() {
        return commandName;
    }

   

    
}
