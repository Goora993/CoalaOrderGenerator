package pl.coalatransport.util;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;

public class NativePathExtractor {

    public static String extractDesktopPath(){
        char[] path = new char[WinDef.MAX_PATH];
        Shell32.INSTANCE.SHGetFolderPath(null,
                ShlObj.CSIDL_DESKTOPDIRECTORY, null, ShlObj.SHGFP_TYPE_CURRENT,
                path);
        System.out.println(Native.toString(path));

        return Native.toString(path);

    }


}
