package pl.coalatransport.util;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;

public class NativePathExtractor {

    public String extractDesktopPath(){
        char[] pszPath = new char[WinDef.MAX_PATH];
        Shell32.INSTANCE.SHGetFolderPath(null,
                ShlObj.CSIDL_DESKTOPDIRECTORY, null, ShlObj.SHGFP_TYPE_CURRENT,
                pszPath);
        System.out.println(Native.toString(pszPath));

        return Native.toString(pszPath);

    }


}
