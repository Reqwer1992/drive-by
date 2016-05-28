package calories.tracker.app.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by alex on 16.26.5.
 */
@PropertySource("classpath:${spring.profiles.active}.properties")
public class FileHelper {

    @Value("${static.file.path}")
    private static String path;

    @Autowired
    String pictureFilePath;

    private static final Logger LOGGER = Logger.getLogger(FileHelper.class);

    public static void saveFile(String uuid, MultipartFile file){
        System.out.println(path);
        if (file != null && !file.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(path + "/" + uuid)));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();

            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
}
