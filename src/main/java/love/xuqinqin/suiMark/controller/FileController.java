package love.xuqinqin.suiMark.controller;

import love.xuqinqin.suiMark.model.dto.FileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Author FGuy
 * @Date 2020/8/23 16:04
 */
@Controller
@RequestMapping("file")
public class FileController {

    @Value("${mark.file.upload.path}")
    private String truePath;

    @Value("${mark.file.upload.vPath}")
    private String vPath;

    @PostMapping("upload")
    @ResponseBody
    public FileDto upload(@RequestParam(value = "editormd-image-file") MultipartFile file) {

        String trueFileName = file.getOriginalFilename();
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + "_" + (int) Math.floor(Math.random() * 900 + 100) + suffix;
        //保存
        try {
            file.transferTo(new File(truePath, fileName));
        } catch (Exception e) {
            e.printStackTrace();
            return new FileDto(0,"upload failed",vPath + fileName);
        }

        return new FileDto(1,"upload success",vPath + fileName);
    }

}
