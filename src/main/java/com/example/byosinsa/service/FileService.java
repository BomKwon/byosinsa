package com.example.byosinsa.service;

import com.example.byosinsa.entity.ProductImg;
import com.example.byosinsa.repository.ProductImgRepository;
import com.example.byosinsa.entity.ProductImg;
import com.example.byosinsa.repository.ProductImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@EnableScheduling
@Component
public class FileService {

    private final ProductImgRepository productImgRepository;


    //파일에 대한 저장
    //  파일명이나 경로를 입력받아 물리적인 파일을 만든다.
    // File 객체 사용 // application.properties의 경로 //uuid
    // 컨트롤러에서 받은 MultipartFile 을 byte타입으로 입력받음
    
    public String uploadFile(String uploadPath, String originalFileName,
                             byte[] fileDate) throws Exception {

        UUID uuid = UUID.randomUUID();
        log.info("생성된 uuid : " + uuid);
        //파일명  abcd // abcd.jpg   자르다 substring ( abcd.jpg 중에서 "." 구분자를 기준으로  )
        String extension = originalFileName.substring(originalFileName.indexOf("."));
        log.info("파일명 . 확장자 제외 : " + extension);
        // asdfkljlwjk123124  + abcd
        String savedFileName = uuid.toString() + originalFileName;
        // 전체 경로  /shop/item/asfjsajkl  + abcd
        String fileUploadFullUrl = uploadPath + "/" + savedFileName;

        //물리적인 파일저장
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
        //만든 객체를 저장합니다. //파라미터로 받은 byte[]타입의 변수
        fos.write(fileDate);
        //자원을 해제
        fos.close();
        // uuid+파일명 //DB에 저장할때 사용하려고?
        return savedFileName;
    }

    public void deleteFile (String filePath) {
        File deleteFile = new File(filePath);
        //이 추상 경로명이 나타내는 파일이나 디렉터리가 존재하는지 테스트합니다.
        // exists() 반환타입 boolean
        if (deleteFile.exists()){
            //파일이 있다면
            deleteFile.delete(); //삭제
            log.info("파일을 삭제 하였습니다.");
        }else {
            log.info("파일이 존재하지 않습니다.");
            //화면에 띄울까? 아니면 개발자만 그대로 볼까? 사용자는
            //파일이 없으니까 아무런 메시지도 없다면 아
            //파일이 있으니 지워졌겠지? 하지않을까?

        }

    }

    //@Scheduled(cron = "0/60 * * * * ?") //60초 마다 실행
    //파일 자동 삭제
//    public void deleteAllFile(){
//        List<ProductImg> productImgList = productImgRepository.findAll();
//
//        List<Path> fileListPaths = productImgList.stream()
//                .map(productImg -> Paths.get("c:\\product",productImg.getUuid() + "_" + productImg.getFilename()))
//                .collect(Collectors.toList());
//
//
//        productImgList.stream()
//                .map(productImg -> Paths.get("c:\\product","s_"+productImg.getUuid() + "_" + productImg.getFilename()))
//                .forEach(p -> fileListPaths.add(p));
//
//        log.info("fileListPaths"+fileListPaths);
//
//        File targetDir = Paths.get("c:\\product\\").toFile();
//
//        log.info("targetDir"+targetDir);
//
//        File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath()) == false);
//
//        log.info("removeFiles"+removeFiles);
//
//        for (File file : removeFiles){
//
//            log.warn(file.getAbsolutePath());
//
//            file.delete();
//        }
//
//    }


}