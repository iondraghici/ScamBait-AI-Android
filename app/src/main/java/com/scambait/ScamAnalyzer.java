package com.example.scambaiter;

public class ScamAnalyzer {
    
    public String detectScamType(String message) {
        message = message.toLowerCase();
        
        if (message.contains("bank") || message.contains("account") || message.contains("login")) {
            return "Banking Scam";
        } else if (message.contains("inheritance") || message.contains("lottery") || message.contains("prize")) {
            return "Advance Fee Scam";
        } else if (message.contains("romance") || message.contains("love") || message.contains("marry")) {
            return "Romance Scam";
        } else if (message.contains("tech support") || message.contains("virus") || message.contains("microsoft")) {
            return "Tech Support Scam";
        } else if (message.contains("irs") || message.contains("tax") || message.contains("government")) {
            return "Government Impersonation";
        } else {
            return "Generic Scam";
        }
    }
}
