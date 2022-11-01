package com.lq.hook

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class Hook: IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        XposedHelpers.findAndHookMethod("mtopsdk.mtop.global.SwitchConfig", lpparam.classLoader, "isGlobalSpdySwitchOpen",
            object : XC_MethodReplacement() {
                override fun replaceHookedMethod(param: MethodHookParam?): Any {
                    XposedBridge.log("替换")
                    return false
                }

            })

        XposedHelpers.findAndHookMethod("mtopsdk.mtop.global.SwitchConfig", lpparam.classLoader, "isGlobalSpdySslSwitchOpen",
            object : XC_MethodReplacement() {
                override fun replaceHookedMethod(param: MethodHookParam?): Any {
                    XposedBridge.log("替换ssl")
                    return false
                }

            })
    }

}