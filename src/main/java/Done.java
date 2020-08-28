public class Done extends Command {

    Done(String[] splitQuery) throws DukeException {
        this.name = "done";
        this.usage = "done [TaskListNumber]";
        this.description = "Marks a task as done in the task list";
        if (splitQuery.length != 2) {
            throw new WrongUsageException(this.name, this.usage);
        }
    }


    public String markedAsDone(String listIndex) throws CustomException {
        int idx;
        try {
            idx = Integer.parseInt(listIndex) - 1;
        } catch (Exception e) {
            throw new CustomException("Error: Please enter a valid integer!");
        }
        if (idx < 0 || idx > DataStorageInterface.getSize() - 1) {
            throw new CustomException("Error: Please enter a number " +
                    "that is in range of the task numbers");
        } else {
            Task curr = DataStorageInterface.markDone(idx);
            return String.format("Nice I have marked this task as done:\n\t%s\n" +
                    "Now you have %d tasks left",curr,DataStorageInterface.getTasksNotDone());
        }
    }

}
