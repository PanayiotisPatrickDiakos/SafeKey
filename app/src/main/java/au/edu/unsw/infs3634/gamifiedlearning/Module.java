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

    public Module(String id, String name, String description, int icon, int difficulty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.difficulty = difficulty;

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


    public static ArrayList<Module> getModules() {
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(new Module("1","Password Protection", "This module will teach you the important things to consider when creating a password for accounts.", R.drawable.ic_baseline_lock_open_24, 4));
        modules.add(new Module("2","Cyber Awareness", "This module will teach you about the levels of awareness and best cybersecuirty practices as well as cyber threats that you may face day-to-day.", R.drawable.ic_baseline_web_24, 3));
        modules.add(new Module("3","Netiquette", "This module teaches you thle sets of rules that encourages appropriate and courteous online  behaviour.", R.drawable.ic_baseline_fingerprint_24, 1));
        modules.add(new Module("4","Phishing Detection", "This module teaches you of the fraudulent practices of sending emails purporting to be from reputable companies in order to induce individuals to reveal personal information.", R.drawable.ic_baseline_pageview_24, 1));
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
