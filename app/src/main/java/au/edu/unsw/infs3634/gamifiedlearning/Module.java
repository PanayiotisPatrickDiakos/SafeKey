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

    /**
     * THIS NEEDS TO CHANGE TO UTILISE FIREBASE DATABASE
     * ONLY TEMPORARY
     * @return
     */
    public static ArrayList<Module> getModules() {
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(new Module("1","Password Protection", R.drawable.md_password, 4));
        modules.add(new Module("2","Phishing Detection", R.drawable.md_password, 3));
        modules.add(new Module("3","Module 3", R.drawable.md_password, 1));
        modules.add(new Module("4","Module 4", R.drawable.md_password, 1));
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
