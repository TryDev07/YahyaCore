package nl.trydev07.yahyacraft.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import org.bukkit.plugin.Plugin;

import java.io.*;

public class GsonUtil<T> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String filePath;
    File file;


    public GsonUtil(Plugin plugin, String name) throws Exception {
        this(plugin, name, false);
    }

    public GsonUtil(Plugin plugin, String name, boolean folder) throws IOException {
        this.filePath = name;
        this.file = new File(plugin.getDataFolder() + name + ".json");
        if (folder) {
            if (!this.file.getParentFile().exists()) this.file.getParentFile().mkdirs();
            if (!this.file.exists()) {
                this.file.createNewFile();
            }
        } else {
            System.out.println(file.exists());

            if (!this.file.exists()) {

                System.out.println(this.file.getPath());
                this.file.createNewFile();
            }
        }
    }


    public void save(Object object) throws Exception {
        if (object == null) return;
        if (this.file == null) return;
        String classInJson = this.gson.toJson(object);
        FileWriter writer = new FileWriter(this.file.getPath());
        writer.write(classInJson);
        writer.close();
    }

    public T load(Class<T> object) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file.getPath()));
        return gson.fromJson(bufferedReader, object);
    }
}
