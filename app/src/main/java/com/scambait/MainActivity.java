package com.example.scambaiter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    private EditText inputMessage;
    private Button analyzeBtn, respondBtn;
    private ListView messagesList;
    private MessageAdapter adapter;
    private ArrayList<ScamMessage> messages = new ArrayList<>();
    private ScamAnalyzer scamAnalyzer;
    private ResponseGenerator responseGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Initialize components
        scamAnalyzer = new ScamAnalyzer();
        responseGenerator = new ResponseGenerator(this);
        
        inputMessage = findViewById(R.id.input_message);
        analyzeBtn = findViewById(R.id.analyze_btn);
        respondBtn = findViewById(R.id.respond_btn);
        messagesList = findViewById(R.id.messages_list);
        
        adapter = new MessageAdapter(this, messages);
        messagesList.setAdapter(adapter);
        
        // Set up button click listeners
        analyzeBtn.setOnClickListener(v -> analyzeMessage());
        respondBtn.setOnClickListener(v -> generateResponse());
    }
    
    private void analyzeMessage() {
        String message = inputMessage.getText().toString();
        if (!message.isEmpty()) {
            String scamType = scamAnalyzer.detectScamType(message);
            ScamMessage scamMessage = new ScamMessage(message, scamType, false);
            messages.add(scamMessage);
            adapter.notifyDataSetChanged();
            inputMessage.setText("");
        }
    }
    
    private void generateResponse() {
        if (!messages.isEmpty()) {
            ScamMessage lastMessage = messages.get(messages.size() - 1);
            String response = responseGenerator.generateResponse(lastMessage);
            ScamMessage responseMessage = new ScamMessage(response, lastMessage.getScamType(), true);
            messages.add(responseMessage);
            adapter.notifyDataSetChanged();
        }
    }
}
