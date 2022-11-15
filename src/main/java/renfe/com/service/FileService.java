package renfe.com.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import renfe.com.util.ConstantesMensajes;


@Service
public class FileService {

	@Value("${files.path}")
	private String filesPath;

	public Resource download(String filename) {
		try {
			Path file = Paths.get(filesPath).resolve(filename);

			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new NullPointerException(ConstantesMensajes.ERROR_LECT_ARCHIVO);
			}
		} catch (MalformedURLException e) {
			throw new NullPointerException(ConstantesMensajes.ERROR_STRING + e.getMessage());
		}
	}

}