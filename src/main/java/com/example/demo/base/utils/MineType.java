package com.example.demo.base.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
public class MineType {
	
	private static Map<String, String> EXT_MAPS = new HashMap<>();
	
	public static String getMineType(String extension) {
		if(EXT_MAPS.size()==0) {
			initExt();
		}
		if(extension==null) {
			return null;
		}
		return EXT_MAPS.get(extension.toLowerCase());
	}
	
	private static void initExt() {
		EXT_MAPS.put("323","text/h323");
		EXT_MAPS.put("acx","application/internet-property-stream");
		EXT_MAPS.put("ai","application/postscript");
		EXT_MAPS.put("aif","audio/x-aiff");
		EXT_MAPS.put("aifc","audio/x-aiff");
		EXT_MAPS.put("aiff","audio/x-aiff");
		EXT_MAPS.put("asf","video/x-ms-asf");
		EXT_MAPS.put("asr","video/x-ms-asf");
		EXT_MAPS.put("asx","video/x-ms-asf");
		EXT_MAPS.put("au","audio/basic");
		EXT_MAPS.put("avi","video/x-msvideo");
		EXT_MAPS.put("axs","application/olescript");
		EXT_MAPS.put("bas","text/plain");
		EXT_MAPS.put("bcpio","application/x-bcpio");
		EXT_MAPS.put("bin","application/octet-stream");
		EXT_MAPS.put("bmp","image/bmp");
		EXT_MAPS.put("c","text/plain");
		EXT_MAPS.put("cat","application/vnd.ms-pkiseccat");
		EXT_MAPS.put("cdf","application/x-cdf");
		EXT_MAPS.put("cer","application/x-x509-ca-cert");
		EXT_MAPS.put("class","application/octet-stream");
		EXT_MAPS.put("clp","application/x-msclip");
		EXT_MAPS.put("cmx","image/x-cmx");
		EXT_MAPS.put("cod","image/cis-cod");
		EXT_MAPS.put("cpio","application/x-cpio");
		EXT_MAPS.put("crd","application/x-mscardfile");
		EXT_MAPS.put("crl","application/pkix-crl");
		EXT_MAPS.put("crt","application/x-x509-ca-cert");
		EXT_MAPS.put("csh","application/x-csh");
		EXT_MAPS.put("css","text/css");
		EXT_MAPS.put("dcr","application/x-director");
		EXT_MAPS.put("der","application/x-x509-ca-cert");
		EXT_MAPS.put("dir","application/x-director");
		EXT_MAPS.put("dll","application/x-msdownload");
		EXT_MAPS.put("dms","application/octet-stream");
		EXT_MAPS.put("doc","application/msword");
		EXT_MAPS.put("dot","application/msword");
		EXT_MAPS.put("dvi","application/x-dvi");
		EXT_MAPS.put("dxr","application/x-director");
		EXT_MAPS.put("eps","application/postscript");
		EXT_MAPS.put("etx","text/x-setext");
		EXT_MAPS.put("evy","application/envoy");
		EXT_MAPS.put("exe","application/octet-stream");
		EXT_MAPS.put("fif","application/fractals");
		EXT_MAPS.put("flr","x-world/x-vrml");
		EXT_MAPS.put("gif","image/gif");
		EXT_MAPS.put("gtar","application/x-gtar");
		EXT_MAPS.put("gz","application/x-gzip");
		EXT_MAPS.put("h","text/plain");
		EXT_MAPS.put("hdf","application/x-hdf");
		EXT_MAPS.put("hlp","application/winhlp");
		EXT_MAPS.put("hqx","application/mac-binhex40");
		EXT_MAPS.put("hta","application/hta");
		EXT_MAPS.put("htc","text/x-component");
		EXT_MAPS.put("htm","text/html");
		EXT_MAPS.put("html","text/html");
		EXT_MAPS.put("htt","text/webviewhtml");
		EXT_MAPS.put("ico","image/x-icon");
		EXT_MAPS.put("ief","image/ief");
		EXT_MAPS.put("iii","application/x-iphone");
		EXT_MAPS.put("ins","application/x-internet-signup");
		EXT_MAPS.put("isp","application/x-internet-signup");
		EXT_MAPS.put("jfif","image/pipeg");
		EXT_MAPS.put("jpe","image/jpeg");
		EXT_MAPS.put("jpeg","image/jpeg");
		EXT_MAPS.put("jpg","image/jpeg");
		EXT_MAPS.put("js","application/x-javascript");
		EXT_MAPS.put("latex","application/x-latex");
		EXT_MAPS.put("lha","application/octet-stream");
		EXT_MAPS.put("lsf","video/x-la-asf");
		EXT_MAPS.put("lsx","video/x-la-asf");
		EXT_MAPS.put("lzh","application/octet-stream");
		EXT_MAPS.put("m13","application/x-msmediaview");
		EXT_MAPS.put("m14","application/x-msmediaview");
		EXT_MAPS.put("m3u","audio/x-mpegurl");
		EXT_MAPS.put("man","application/x-troff-man");
		EXT_MAPS.put("mdb","application/x-msaccess");
		EXT_MAPS.put("me","application/x-troff-me");
		EXT_MAPS.put("mht","message/rfc822");
		EXT_MAPS.put("mhtml","message/rfc822");
		EXT_MAPS.put("mid","audio/mid");
		EXT_MAPS.put("mny","application/x-msmoney");
		EXT_MAPS.put("mov","video/quicktime");
		EXT_MAPS.put("movie","video/x-sgi-movie");
		EXT_MAPS.put("mp2","video/mpeg");
		EXT_MAPS.put("mp3","audio/mpeg");
		EXT_MAPS.put("mpa","video/mpeg");
		EXT_MAPS.put("mpe","video/mpeg");
		EXT_MAPS.put("mpeg","video/mpeg");
		EXT_MAPS.put("mpg","video/mpeg");
		EXT_MAPS.put("mpp","application/vnd.ms-project");
		EXT_MAPS.put("mpv2","video/mpeg");
		EXT_MAPS.put("ms","application/x-troff-ms");
		EXT_MAPS.put("mvb","application/x-msmediaview");
		EXT_MAPS.put("nws","message/rfc822");
		EXT_MAPS.put("oda","application/oda");
		EXT_MAPS.put("p10","application/pkcs10");
		EXT_MAPS.put("p12","application/x-pkcs12");
		EXT_MAPS.put("p7b","application/x-pkcs7-certificates");
		EXT_MAPS.put("p7c","application/x-pkcs7-mime");
		EXT_MAPS.put("p7m","application/x-pkcs7-mime");
		EXT_MAPS.put("p7r","application/x-pkcs7-certreqresp");
		EXT_MAPS.put("p7s","application/x-pkcs7-signature");
		EXT_MAPS.put("pbm","image/x-portable-bitmap");
		EXT_MAPS.put("pdf","application/pdf");
		EXT_MAPS.put("pfx","application/x-pkcs12");
		EXT_MAPS.put("pgm","image/x-portable-graymap");
		EXT_MAPS.put("pko","application/ynd.ms-pkipko");
		EXT_MAPS.put("pma","application/x-perfmon");
		EXT_MAPS.put("pmc","application/x-perfmon");
		EXT_MAPS.put("pml","application/x-perfmon");
		EXT_MAPS.put("pmr","application/x-perfmon");
		EXT_MAPS.put("pmw","application/x-perfmon");
		EXT_MAPS.put("pnm","image/x-portable-anymap");
		EXT_MAPS.put("pot,","application/vnd.ms-powerpoint");
		EXT_MAPS.put("ppm","image/x-portable-pixmap");
		EXT_MAPS.put("pps","application/vnd.ms-powerpoint");
		EXT_MAPS.put("ppt","application/vnd.ms-powerpoint");
		EXT_MAPS.put("prf","application/pics-rules");
		EXT_MAPS.put("ps","application/postscript");
		EXT_MAPS.put("pub","application/x-mspublisher");
		EXT_MAPS.put("qt","video/quicktime");
		EXT_MAPS.put("ra","audio/x-pn-realaudio");
		EXT_MAPS.put("ram","audio/x-pn-realaudio");
		EXT_MAPS.put("ras","image/x-cmu-raster");
		EXT_MAPS.put("rgb","image/x-rgb");
		EXT_MAPS.put("rmi","audio/mid");
		EXT_MAPS.put("roff","application/x-troff");
		EXT_MAPS.put("rtf","application/rtf");
		EXT_MAPS.put("rtx","text/richtext");
		EXT_MAPS.put("scd","application/x-msschedule");
		EXT_MAPS.put("sct","text/scriptlet");
		EXT_MAPS.put("setpay","application/set-payment-initiation");
		EXT_MAPS.put("setreg","application/set-registration-initiation");
		EXT_MAPS.put("sh","application/x-sh");
		EXT_MAPS.put("shar","application/x-shar");
		EXT_MAPS.put("sit","application/x-stuffit");
		EXT_MAPS.put("snd","audio/basic");
		EXT_MAPS.put("spc","application/x-pkcs7-certificates");
		EXT_MAPS.put("spl","application/futuresplash");
		EXT_MAPS.put("src","application/x-wais-source");
		EXT_MAPS.put("sst","application/vnd.ms-pkicertstore");
		EXT_MAPS.put("stl","application/vnd.ms-pkistl");
		EXT_MAPS.put("stm","text/html");
		EXT_MAPS.put("svg","image/svg+xml");
		EXT_MAPS.put("sv4cpio","application/x-sv4cpio");
		EXT_MAPS.put("sv4crc","application/x-sv4crc");
		EXT_MAPS.put("swf","application/x-shockwave-flash");
		EXT_MAPS.put("t","application/x-troff");
		EXT_MAPS.put("tar","application/x-tar");
		EXT_MAPS.put("tcl","application/x-tcl");
		EXT_MAPS.put("tex","application/x-tex");
		EXT_MAPS.put("texi","application/x-texinfo");
		EXT_MAPS.put("texinfo","application/x-texinfo");
		EXT_MAPS.put("tgz","application/x-compressed");
		EXT_MAPS.put("tif","image/tiff");
		EXT_MAPS.put("tiff","image/tiff");
		EXT_MAPS.put("tr","application/x-troff");
		EXT_MAPS.put("trm","application/x-msterminal");
		EXT_MAPS.put("tsv","text/tab-separated-values");
		EXT_MAPS.put("txt","text/plain");
		EXT_MAPS.put("uls","text/iuls");
		EXT_MAPS.put("ustar","application/x-ustar");
		EXT_MAPS.put("vcf","text/x-vcard");
		EXT_MAPS.put("vrml","x-world/x-vrml");
		EXT_MAPS.put("wav","audio/x-wav");
		EXT_MAPS.put("wcm","application/vnd.ms-works");
		EXT_MAPS.put("wdb","application/vnd.ms-works");
		EXT_MAPS.put("wks","application/vnd.ms-works");
		EXT_MAPS.put("wmf","application/x-msmetafile");
		EXT_MAPS.put("wps","application/vnd.ms-works");
		EXT_MAPS.put("wri","application/x-mswrite");
		EXT_MAPS.put("wrl","x-world/x-vrml");
		EXT_MAPS.put("wrz","x-world/x-vrml");
		EXT_MAPS.put("xaf","x-world/x-vrml");
		EXT_MAPS.put("xbm","image/x-xbitmap");
		EXT_MAPS.put("xla","application/vnd.ms-excel");
		EXT_MAPS.put("xlc","application/vnd.ms-excel");
		EXT_MAPS.put("xlm","application/vnd.ms-excel");
		EXT_MAPS.put("xls","application/vnd.ms-excel");
		EXT_MAPS.put("xlt","application/vnd.ms-excel");
		EXT_MAPS.put("xlw","application/vnd.ms-excel");
		EXT_MAPS.put("xof","x-world/x-vrml");
		EXT_MAPS.put("xpm","image/x-xpixmap");
		EXT_MAPS.put("xwd","image/x-xwindowdump");
		EXT_MAPS.put("z","application/x-compress");
		EXT_MAPS.put("zip","application/zip");
        // image
        EXT_MAPS.put("png", "image/png");
        EXT_MAPS.put("gif", "image/gif");
        EXT_MAPS.put("bmp", "image/bmp");
        EXT_MAPS.put("ico", "image/x-ico");
        EXT_MAPS.put("jpeg", "image/jpeg");
        EXT_MAPS.put("jpg", "image/jpeg");
        // 压缩文件
        EXT_MAPS.put("zip", "application/zip");
        EXT_MAPS.put("rar", "application/x-rar");
        // doc
        EXT_MAPS.put("pdf", "application/pdf");
        EXT_MAPS.put("ppt", "application/vnd.ms-powerpoint");
        EXT_MAPS.put("xls", "application/vnd.ms-excel");
        EXT_MAPS.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        EXT_MAPS.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        EXT_MAPS.put("doc", "application/msword");
        EXT_MAPS.put("doc", "application/wps-office.doc");
        EXT_MAPS.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        EXT_MAPS.put("txt", "text/plain");
        // 音频
        EXT_MAPS.put("mp4", "video/mp4");
        EXT_MAPS.put("flv", "video/x-flv");
		//新增
		EXT_MAPS.put("m3u8","application/vnd.apple.mpegurl");
		EXT_MAPS.put("3gp","application/octet-stream");
		EXT_MAPS.put("webp","image/jpeg");

    }
}
