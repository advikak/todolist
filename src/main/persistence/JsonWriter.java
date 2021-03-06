package persistence;

import model.ToDoList;
import org.json.JSONObject;


import java.io.*;

// This class references code from the workroom app
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
// Represents a writer that writes JSON representation of todolist to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: open writer; throws FileNotFoundException if destination file cannot
    // be opened
    public void open() throws FileNotFoundException {
        writer = new PrintWriter((destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of todolist to file
    public void write(ToDoList t) {
        JSONObject json = t.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes this writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}

