package au.edu.unsw.infs3634.gamifiedlearning;

import android.util.Log;

import java.util.ArrayList;

public class Module {
    private static final String TAG = "Module";
    private String id;
    private String name;
    private int icon;
    private int difficulty;

    public Module(String id, String name, int icon, int difficulty) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.difficulty = difficulty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        modules.add(new Module("1","Password Protection", R.drawable.ic_baseline_lock_open_24, 4));
        modules.add(new Module("2","Cyber Awareness", R.drawable.ic_baseline_web_24, 3));
        modules.add(new Module("3","Netiquette", R.drawable.ic_baseline_fingerprint_24, 1));
        modules.add(new Module("4","Phishing Detection", R.drawable.ic_baseline_pageview_24, 1));
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
