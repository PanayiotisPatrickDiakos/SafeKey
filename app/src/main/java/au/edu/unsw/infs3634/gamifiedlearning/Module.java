package au.edu.unsw.infs3634.gamifiedlearning;

import android.util.Log;

import java.util.ArrayList;

public class Module {
    private static final String TAG = "Module";
    private String id;
    private String name;
    private String description;
    private int icon;
    private int difficulty;
    private String theory;

    public Module(String id, String name, String description, int icon, int difficulty, String theory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.difficulty = difficulty;
        this.theory = theory;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public static ArrayList<Module> getModules() {
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(new Module("1","Password Protection", "This module will teach you the important things to consider when creating a password for accounts.", R.drawable.ic_baseline_lock_open_24, 4,
                "Brief \n" +
                        "\n" +
                        "To prevent others that are unknow to you from using your account, having a strong password can ensure you have a greater layer of security against malicious actors. \n" +
                        "\n" +
                        "Password Best Practice: \n" +
                        "\n" +
                        "Researches have suggested that the best password share the following characteristics: \n" +
                        "\n" +
                        "16 or more characters \n" +
                        "\n" +
                        "Contain: Letters, numbers, symbols \n" +
                        "\n" +
                        "No personal information \n" +
                        "\n" +
                        "No repeating parts \n" +
                        "\n" +
                        "Not shared with other accounts \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Being honest and being realistic: \n" +
                        "\n" +
                        "For example, a password such as “1b9#n8a^8&” is very strong but not a realistic expectation. \n" +
                        "\n" +
                        "The average user has 150 accounts, it would be very difficult to remember 150 variations of something similar.  \n" +
                        "\n" +
                        "As long as the password is strong, computers and malicious actors will struggle to brute force it, making your account safe. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Our Suggestion for being strong while also being reasonable \n" +
                        "\n" +
                        "Greater than 10 Characters \n" +
                        "\n" +
                        "Contain Letters, numbers and symbols \n" +
                        "\n" +
                        "No Personal Information \n" +
                        "\n" +
                        "No repeating parts \n" +
                        "\n" +
                        "Shared with a maximum of 10 accounts \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Other Protections: \n" +
                        "\n" +
                        "To make yourself more secure enable multifactor authentication on accounts and test your passwords strength online. People will also never ask for you passwords, if they do, don’t give it to them. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Importance \n" +
                        "\n" +
                        "Protecting your password protects your personal data. This could include phone numbers, date of births and addresses. This could lead to identity theft where someone imitates you. \n" +
                        "\n" +
                        "These people could also steal financial details such as your bank details. This can lead to your money you earned to be stolen. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Bottom Line \n" +
                        "\n" +
                        "Protect yourself and those around you by keeping your passwords strong to minimise the chance of being breached. "));
        modules.add(new Module("2","Cyber Awareness", "This module will teach you about the levels of awareness and best cybersecuirty practices as well as cyber threats that you may face day-to-day.", R.drawable.ic_baseline_web_24, 3,
                "Module: \n" +
                        "\n" +
                        "It is important to know how to identify a scam and know what to do when you think they are occurring. It is best to not follow through on any request that suspicious people make. \n" +
                        "\n" +
                        "Here are some top tips from the ACCC: \n" +
                        "\n" +
                        "Scammers often pretend to be trusted organisations such as the government, banks, energy or telecommunications companies. They will try to imitate these companies. \n" +
                        "\n" +
                        "Beware of requests for your details or money. Never send money, personal or financial details, or copies of identity documents to anyone you don’t know or trust. People will also never ask for you passwords. \n" +
                        "\n" +
                        "Never click on hyperlinks or open attachments in suspicious emails or text messages. Verify the contact using an independent source like an online search.  \n" +
                        "\n" +
                        "Don’t respond to phone calls about your computer asking for remote access – hang up.  \n" +
                        "\n" +
                        "Be wary of unusual payment requests such as preloaded debit or gift cards, up-front wire transfers or virtual currency such as Bitcoin.  \n" +
                        "\n" +
                        "Verify any changes to bank account details by directly calling the individual or business you are dealing with using trusted contact details. Know the contact details of companies you deal with. \n" +
                        "\n" +
                        "If an offer seems too good to be true, it probably is."));
        modules.add(new Module("3","Netiquette", "This module teaches you thle sets of rules that encourages appropriate and courteous online  behaviour.", R.drawable.ic_baseline_fingerprint_24, 1,
                "We all like to behave in a respectful manner when we talk and interact with people in person. This is known as having etiquette. So, when we switch and do this in an online environment or the internet (net for short), we need to have netiquette. \n" +
                        "\n" +
                        "Dictionary Definition: \n" +
                        "\n" +
                        "The correct or acceptable way of using the internet. \n" +
                        "\n" +
                        "Key Rules: \n" +
                        "\n" +
                        "Use respectful language: Just like talking to people in real life, although you can’t see them you are still talking to a real person. Make sure you read back what you wrote to make sure that it made sense. \n" +
                        "\n" +
                        "Don’ Make assumptions: Don’t assume, sharing of content without permission is not ethical. If you want to share it make sure to ask for their permission. Also don’t assume that people know what you are talking about, you need to give some context. \n" +
                        "\n" +
                        "Be inclusive: Keep everyone involved and don’t forget about others, just because they don’t see you, doesn’t mean they don’t know what you are up to. This is cyber bulying, don’t promote it. \n" +
                        "\n" +
                        "Don’t Spam: You wouldn’t scream the same thing and repeat yourself in people’s faces. Lot’s of notifications are annoying for some people. \n" +
                        "\n" +
                        "Don’t be rude: Don’t talk about others in a negative way, they may eventually find out even if you delete it. People may get angry at things that you say, just like in real life. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "The most important thing is that you use the correct language, be sure to address who you are talking to and make sure you are identifiable. Make sure you use proper communication channels and don’t use personal contacts for work related items. If someone asks you to communicate with them in a certain way make sure you follow through with their request, otherwise they may end up ignoring you.  \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "“What goes on the internet, stays on the internet.” Even if you delete things, people may have copies even if you didn’t consent. If  you post or say something through a digital medium, be aware that everyone may see it. So don’t talk about others in a negative way. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "The most important takeway is to behave like you would in the real world making some small positive adjustments, even though you are in your own world with a screen in front of you."));
        modules.add(new Module("4","Phishing Detection", "This module teaches you of the fraudulent practices of sending emails purporting to be from reputable companies in order to induce individuals to reveal personal information.", R.drawable.ic_baseline_pageview_24, 1,
                "Since early March 2020, the Australian Cyber Security Centre (ACSC) has seen an increase in reporting from individuals, businesses and government departments about a range of different COVID-19 themed scams, online frauds and phishing campaigns.\n" +
                        "\n" +
                        "Cybercriminals send phishing messages all the time. But crises like COVID-19 sadly provide more opportunity for cybercriminals to take advantage of vulnerable people wanting additional information by imitating trusted, well-known organisations or government agencies who might provide answers.\n" +
                        "\n" +
                        "The phishing messages we’ve seen use all sorts of lures to trick people into handing over their personal details. For example, we’ve seen fake reports of new local virus cases and safety measures to prevent the spread, as well as emails on how to access government benefits or financial assistance payments. There have also been reports of fake online stores offering to sell non-existent products, including cures or vaccinations for the COVID-19 pandemic and protective items such as face masks.\n" +
                        "\n" +
                        "Phishing messages can be sent via email, SMS, social media, instant messaging platforms or phone calls. They can look extremely authentic and convincing, replicating legitimate messages from trusted senders.\n" +
                        "\n" +
                        "As well as featuring official-looking logos and disclaimers, phishing emails typically include a 'call to action' to trick recipients into sharing sensitive personal information from passwords to banking details.\n" +
                        "\n" +
                        "Examples of phishing techniques include sending malicious links or attachments to a potential victim and requesting personal information such as name, date of birth, credit card number, or even usernames and passwords.\n" +
                        "\n" +
                        "Identifying these messages as fakes can be very difficult, as cybercriminals go to great lengths to make them appear genuine. If you think a message you have received is not legitimate, there are techniques you can use to verify the message."));
        return modules;
    }

    public static Module getModule(String symbol) {
        Log.d(TAG, "getDestination Running" + symbol);
        ArrayList<Module> modules = Module.getModules();
        for(final Module module : modules) {
            if(module.getId().equals(symbol)) {
                return module;
            }
        }
        return null;
    }
}
