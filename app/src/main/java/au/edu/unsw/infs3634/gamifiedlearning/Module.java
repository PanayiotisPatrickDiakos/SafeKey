package au.edu.unsw.infs3634.gamifiedlearning;

import java.util.ArrayList;

public class Module {
    private String name;
    private int icon;

    public Module(String name, int icon) {
        this.name = name;
        this.icon = icon;
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

    /**
     * THIS NEEDS TO CHANGE TO UTILISE FIREBASE DATABASE
     * ONLY TEMPORARY
     * @return
     */
    public static ArrayList<Module> getModules() {
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(new Module("Password Protection", R.drawable.md_password));
        modules.add(new Module("Phishing Detection", R.drawable.md_password));
        modules.add(new Module("Module 3", R.drawable.md_password));
        modules.add(new Module("Module 4", R.drawable.md_password));
        return modules;
    }
}
