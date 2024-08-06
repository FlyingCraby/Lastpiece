import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Lastpiece Plugin ON!");
    }

    @Override
    public void onDisable() {
        System.out.println("Lastpiece Plugin OFF!");
    }
}