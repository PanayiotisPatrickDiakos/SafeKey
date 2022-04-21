package au.edu.unsw.infs3634.gamifiedlearning;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {
    public static List<QuestionsList> PSecurityModule() {
        List<QuestionsList> questionsList = new ArrayList<>();
        questionsList.add(new QuestionsList("Which of the following is the most commonly used (and therefore the weakest) password?",
                "123456", "Asdf", "Iloveyou", "Monkey", "123456", ""));
        questionsList.add(new QuestionsList("Ideally, what characters should you use in a password to make it strong?",
                "Letters and Numbers only.", "Mixed Case (Upper and Lower) Characters", "Special Characters", "All of the above", "All of the above", ""));
        questionsList.add(new QuestionsList("Strong passwords can be difficult to remember. What can you do to avoid forgetting them?",
                "Use memorable phrases", "Develop a password strategy", "Use password management software with encryption.", "All of the above", "All of the above", ""));
        questionsList.add(new QuestionsList("I have a really strong password, so I should just use it for:",
                "All my accounts","Some of my accounts","A few of my accounts","Only one account","Only one account",""));
        questionsList.add(new QuestionsList("How long would it take an attacker to crack a 10 character password?",
                "Less than an hour","Less than a week","Less than a month","It depends!","It depends!",""));
        questionsList.add(new QuestionsList("How long should a strong password be?",
                "8 Characters","15 Characters","As long as possible","It doesn’t matter","As long as possible",""));
        questionsList.add(new QuestionsList("When adding a phone password - what is the safest lockscreen password type?",
                "Biometrics (Face scanner and/or Fingerprint)","None","Pattern","4 digit code","Biometrics (Face scanner and/or Fingerprint)",""));
        questionsList.add(new QuestionsList("When it’s time to change your password, what’s the best way to choose a new one?",
                "Add a number or special character to the end of your old password.",
                "Pick something easy to remember, such as a football team or your birthday.",
                "Choose something quick and easy to type in so nobody can see it.",
                "Choose something you can remember, but modify it with a complex pattern that only you know.",
                "Choose something you can remember, but modify it with a complex pattern that only you know.",""));
        questionsList.add(new QuestionsList("Where would it be safest and best to store my passwords",
                "Password Manager application","In a word document named \"Passwords\"","In my diary that I keep at work","Nowhere - I will remember them","Password Manager application",""));
        questionsList.add(new QuestionsList("Now that you are an expert, choose the strongest password from this list:",
                "Safekey1","C0mput3r","S@f3{ExTR3M3}P@$$w0rd","Th3 m0nk3y 3475 b4n4n4s","S@f3{ExTR3M3}P@$$w0rd",""));
        return questionsList;
    }

    private static List<QuestionsList> CAwarenessModule() {
        List<QuestionsList> questionsList = new ArrayList<>();

        questionsList.add(new QuestionsList("What should you do if you think your identity or accounts have been compromised?",
                "Monitor your email address and accounts for fraudulent activity.",
                "Respond to the warning email you have received.",
                "Subscribe to a monitoring service such as Lifelock or WebWatcher.",
                "Nothing", "Monitor your email address and accounts for fraudulent activity.", ""));
        questionsList.add(new QuestionsList("The best defence against ransomware is being proactive when you:",
                "Purchase comprehensive cybersecurity insurance",
                "Backup your data regularly",
                "Regularly update all your devices and software with the latest security patches",
                "Buy the latest iPhone", "Backup your data regularly", ""));
        questionsList.add(new QuestionsList("What's the best way to steer clear of IoT device security hacks?",
                "Only choose name-brand hardware makers",
                "Disconnect IoT devices fom the internet when you are not using them",
                "Have all devices turned on at all times",
                "Do not purchase any IoT devices you do not need", "Do not purchase any IoT devices you do not need", ""));
        questionsList.add(new QuestionsList("Which ride-sharing service collects the least amount of your data?",
                "Uber",
                "Lyft",
                "Didi",
                "Public Taxis", "Public Taxis", ""));
        questionsList.add(new QuestionsList("What is the best way to keep employees from falling for phishing scams?",
                "Email filters that block suspicious attachments",
                "Cybersecurity awareness training",
                "Pop-up blockers",
                "All of the above", "All of the above", ""));
        questionsList.add(new QuestionsList("What is the best way to maintain privacy between two parties?",
                "Long and strong passwords and two-factor authentication",
                "End-to-end encryption",
                "Encrypted cloud services",
                "There isn't", "End-to-end encryption", ""));
        questionsList.add(new QuestionsList("Which of the following cryptocurrency statements is false?",
                "Cryptocurrency is currently not a legal form of payment in Australia",
                "Each new Bitcoin mined requires slightly more energy than the previous one",
                "Blockchain is the digital ledger that records all cryptocurrency transactions",
                "Cryptocurrency is 100 times more secure than traditional currency", "Cryptocurrency is 100 times more secure than traditional currency", ""));
        questionsList.add(new QuestionsList("Which part of your car is the most vulnerable to hacking?",
                "Engine",
                "Cruise control",
                "Wireless key fob",
                "Entertainment System", "Wireless key fob", ""));
        questionsList.add(new QuestionsList("Which one of these things is most effective for maintaining your digital privacy?",
                "Not sharing personal information on social media",
                "Unsubscribing from all spam emails",
                "Covering your computer’s front-facing camera",
                "Giving everyone your email password just incase you forget", "Not sharing personal information on social media", ""));
        questionsList.add(new QuestionsList("The best way to minimize your digital footprint is to",
                "Take fewer photos with your smartphone",
                "Travel less with your smartphone",
                "Post less on social media",
                "Don't take feet pictures", "Post less on social media", ""));
        return questionsList;
    }

    private static List<QuestionsList> NetiquetteModule() {
        List<QuestionsList> questionsList = new ArrayList<>();
        questionsList.add(new QuestionsList("Typing in all capitals in electronic communications means:",
                "This message is very important", "You are shouting", "It's okay to forward this message to others", "nothing special--typing in all caps is normal", "You are shouting", ""));
        questionsList.add(new QuestionsList("It is OK to forward or post an email message that you received if",
                "The message is typed in all capitals",
                "The author of the message has given you permission to forward or post it",
                "It does not contain any copyrighted material",
                "The author of the message hasn't marked it as confidential",
                "The author of the message has given you permission to forward or post it", ""));
        questionsList.add(new QuestionsList("Before posting to a discussion group you should",
                "Read the FAQ", "Find the FAQ Document", "Read some of the existing posts to get an idea of the tone and character of the group", "All of the above", "All of the above", ""));
        questionsList.add(new QuestionsList("A flame is",
                "A post or email message that expresses a strong opinion or criticism",
                "An expert programmer",
                "A person who consistently breaks the rules of Netiquette",
                "An online chain letter", "A post or email message that expresses a strong opinion or criticism", ""));
        questionsList.add(new QuestionsList("The phrase \"lurk before you leap\" means",
                "Send your post to the moderator via email before posting it to a discussion group",
                "Make sure there isn't a host moderating the chat before you scroll the chat screen",
                "Post test messages to several USENET newsgroups before posting a real message",
                "Familiarize yourself with a discussion group before actively participating",
                "Familiarize yourself with a discussion group before actively participating", ""));
        questionsList.add(new QuestionsList("The Golden Rule of Netiquette is",
                "Remember the human!", "A smiley in every message.",
                "Follow the other rules of netiquette",
                "never flame a friend", "Remember the human!",""));
        questionsList.add(new QuestionsList("Spamming is very poor Netiquette and means",
                "Sending in lines of nonsensical garbage in a chat conversation",
                "Posting a message that contains graphic descriptions of something really gross",
                "Spilling the juice of meat-byproducts into your keyboard.",
                "Posting or emailing repeated unsolicited advertising messages to a wide audience", "Posting or emailing repeated unsolicited advertising messages to a wide audience", ""));
        questionsList.add(new QuestionsList("Knowledge and understanding of netiquette is useful because",
                "It will help you create a positive impression on those you meet in cyberspace",
                "It explains some of the technical limitations of online communications",
                "It explains the conventions already being used by millions of cybernauts",
                "All of the above",
                "It explains the conventions already being used by millions of cybernauts", ""));
        questionsList.add(new QuestionsList("Appropriate content for email messages includes",
                "Anything you wouldn't mind having subpoenaed as part of a court proceeding",
                "Anything you wouldn't mind seeing on the evening news",
                "Anything you wouldn't mind your grandmother seeing",
                "All of the above", "All of the above", ""));
        questionsList.add(new QuestionsList("Include a subject line",
                "Only when you are writing an official memo",
                "Only in personal memos",
                "If the person you are sending it to requires one",
                "In all e-mail messages",
                "In all e-mail messages", ""));
        return questionsList;
    }

    private static List<QuestionsList> PhishingModule() {
        List<QuestionsList> questionsList = new ArrayList<>();
        questionsList.add(new QuestionsList("What is phishing?",
                "Scams through websites",
                "Scams through phone calls",
                "Scams through emails", "Scams through texts", "Scams through emails", ""));
        questionsList.add(new QuestionsList("Sara finds a message on her phone that she thinks might be a scam.  She should:",
                "Forward the message to her friends to see if they think it's a scam too.",
                "Reply and ask the sender not to send anymore emails", "Open the email and then delete it",
                "Delete the message", "Delete the message", ""));
        questionsList.add(new QuestionsList("What should you do as an employee if you suspect a phishing attack?",
                "Report it so the organization can investigate.","Open the email and see whether it looks legitimate.", "Show your coworkers to see what they think.", "Ignore it","Report it so the organization can investigate.",""));

        questionsList.add(new QuestionsList("How many phishing emails are sent each day worldwide?",
                        "10 million","25 million","75 million","150 million","150 million",""));

        questionsList.add(new QuestionsList("How long would it take an attacker to crack a 10 character password?",
                "Less than an hour","Less than a week","Less than a month","It depends!","It depends!",""));

        questionsList.add(new QuestionsList("What can happen if you click on a phishing email link or attachment?",
                "The email sender could gain access to company systems.",
                "The email sender could steal your personal information or company information.",
                "The email sender could distribute malware into the company network.",
                "All of the above",
                "All of the above",""));

        questionsList.add(new QuestionsList("When adding a phone password - what is the safest lockscreen password type?",
                "Biometrics (Face scanner and/or Fingerprint)","None","Pattern","4 digit code","Biometrics (Face scanner and/or Fingerprint)",""));

        questionsList.add(new QuestionsList("Teens are some of the most frequent targets of identity theft and other scams. Why?",
                "Identity thieves look for “clean” Social Security numbers that haven’t yet been used to get credit.",
                "Thieves want to help teens get student loans for college",
                "It will help teens do better in school",
                "Identity thieves are just testing teens to see if they will fall for their scams",
        "Identity thieves look for “clean” Social Security numbers that haven’t yet been used to get credit.",""));
        questionsList.add(new QuestionsList("You should change your password",
                "Never",
                "As often as possible",
                "Only when I get attacked",
                "Once a year","As often as possible",""));
        questionsList.add(new QuestionsList("What is spear fishing?",
                "A type of phishing that involves vacation offers",
                "A type of phishing that promises a large reward",
                "A type of phishing that targets specific groups of people in an organization",
                "A type of phishing that lures the recipient in with a fun offer and then spreads a virus","A type of phishing that targets specific groups of people in an organization .",""));
        return questionsList;
    }

    public static List<QuestionsList> getQuestions(String selectedModule) {
        switch (selectedModule) {
            case "Password Protection":
                return PSecurityModule();
            case "Cyber Awareness":
                return CAwarenessModule();
            case "Netiquette":
                return NetiquetteModule();
            case "Phishing Detection":
                return PhishingModule();
            default:
                return null;
        }
    }
}
