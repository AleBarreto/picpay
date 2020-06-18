package costa.barreto.picpay

import android.net.Uri
import android.provider.Telephony
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val grantPermissionRule : GrantPermissionRule = GrantPermissionRule.grant(android.Manifest.permission.READ_SMS)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("costa.barreto.picpay", appContext.packageName)
    }


    @Test
    fun testAle(){
        val appContext = InstrumentationRegistry.getInstrumentation().context

        val cursor = appContext.contentResolver.query(Telephony.Carriers.CONTENT_URI,null,null,null,null)
        if (cursor != null){
            cursor.moveToFirst()
            do {
                Log.d("ALECOSTA",cursor.getString(cursor.getColumnIndex("plmn")))
                Log.d("ALECOSTA",cursor.getString(cursor.getColumnIndex("nwkname")))
                Log.d("ALECOSTA","################################################3")
            }while (cursor.moveToNext())

        }else{
            Log.d("ALECOSTA","cursor null");
        }
    }

}
