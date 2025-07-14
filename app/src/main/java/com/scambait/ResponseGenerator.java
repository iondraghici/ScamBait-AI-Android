package com.example.scambaiter;

import android.content.Context;
import java.util.Random;

public class ResponseGenerator {
    
    private Context context;
    private Random random = new Random();
    
    public ResponseGenerator(Context context) {
        this.context = context;
    }
    
    public String generateResponse(ScamMessage scamMessage) {
        String scamType = scamMessage.getScamType();
        String[] responses;
        
        switch (scamType) {
            case "Banking Scam":
                responses = context.getResources().getStringArray(R.array.banking_responses);
                break;
            case "Advance Fee Scam":
                responses = context.getResources().getStringArray(R.array.advance_fee_responses);
                break;
            case "Romance Scam":
                responses = context.getResources().getStringArray(R.array.romance_responses);
                break;
            case "Tech Support Scam":
                responses = context.getResources().getStringArray(R.array.tech_support_responses);
                break;
            case "Government Impersonation":
                responses = context.getResources().getStringArray(R.array.gov_responses);
                break;
            default:
                responses = context.getResources().getStringArray(R.array.generic_responses);
        }
        
        return responses[random.nextInt(responses.length)];
    }
}
