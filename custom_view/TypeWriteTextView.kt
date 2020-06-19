import android.content.Context
import android.os.Build
import android.os.Handler
import android.text.Html
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TypeWriteTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatTextView(context, attrs, defStyleAttr) {
    private lateinit var mText: CharSequence
    private var len = 0
    private var mIndex = 0
    private var mDelay: Long = 100
    private var colorCode1: String = "#000000"
    private var colorCode2: String = "#FFFFFF"

    private val mHandler = Handler()
    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            text = mText.subSequence(0, mIndex++)
            if (mIndex <= mText.length) {
                mHandler.postDelayed(this, mDelay)
            }
        }
    }

    private val characterBlankFiller: Runnable = object : Runnable {
        override fun run() {
            var blankStr = ""
            for( i in 0 until len){
                blankStr+=when(mText[i]){
                    ' ', ',', '.', '!','a','b','c','d',
                    'e','f','g','h','i','j','k','l','m',
                    'n','o','p','q','r','s','t','u','v',
                    'w','x','y','z','0','1','2','3','4',
                    '5','6','7','8','9','-','+','?','(',
                    ')', '*', '\\', '~'->{
                        " "
                    }
                    else->{
                        "ㅤ"
                    }
                }
            }

            text = "${mText.subSequence(0, mIndex)}${blankStr.subSequence(mIndex, len)}"
            mIndex++
            if (mIndex <= mText.length) {
                mHandler.postDelayed(this, mDelay)
            }
        }
    }

    private val characterHtmlFiller: Runnable = object : Runnable {
        override fun run() {
            val htmlStr = "<font>${mText.subSequence(0, mIndex)}</font><font color='#FFF'>${mText.subSequence(mIndex, len)}</font>"
            text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(htmlStr, Html.FROM_HTML_MODE_COMPACT)
            } else {
                Html.fromHtml(htmlStr)
            }
            
            mIndex++
            if (mIndex <= mText.length) {
                mHandler.postDelayed(this, mDelay)
            }
        }
    }

    // Set character delay time for typewriting animation
    fun setCharDelay(millis: Long) {
        mDelay = millis
    }

    // Passing animated text from parent class
    fun animateChunkText(text: CharSequence, num: Int) {
        var tmpStr = ""
        var i = 0
        text.forEach {
            if (it == ' ') {
                i++
                tmpStr += if (i % num == 0) { "\n" } else { " " }
            } else {
                tmpStr += it
            }
        }
        mText = tmpStr

        mIndex = 0
        setText("")
        mHandler.removeCallbacks(characterAdder)
        mHandler.removeCallbacks(characterBlankFiller)
        mHandler.removeCallbacks(characterHtmlFiller)
        mHandler.postDelayed(characterAdder, mDelay)
    }

    fun animatePlainText(text: CharSequence) {
        mText = text

        mIndex = 0
        setText("")
        mHandler.removeCallbacks(characterAdder)
        mHandler.removeCallbacks(characterBlankFiller)
        mHandler.removeCallbacks(characterHtmlFiller)
        mHandler.postDelayed(characterAdder, mDelay)
    }


    fun animatePlainTextInPlace(text: CharSequence){
        mText = text
        len = text.length

        mIndex = 0
        setText("")
        mHandler.removeCallbacks(characterAdder)
        mHandler.removeCallbacks(characterBlankFiller)
        mHandler.removeCallbacks(characterHtmlFiller)
        mHandler.postDelayed(characterBlankFiller, mDelay)
    }

    fun animateHtmlTextInPlace(text: CharSequence, colorCode1: String, colorCode2: String){
        if(colorCode1.length > 7 || colorCode2.length > 7){
            throw InvalidColorStringException("too long length(${colorCode1.length}, ${colorCode2.length}). It must be 7.")
        }else if(colorCode1.length < 7 || colorCode2.length < 7){
            throw InvalidColorStringException("too short length(${colorCode1.length}, ${colorCode2.length}). It must be 7.")
        }
        this.colorCode1 = colorCode1
        this.colorCode2 = colorCode2

        mText = text
        len = text.length

        mIndex = 0
        setText("")
        mHandler.removeCallbacks(characterAdder)
        mHandler.removeCallbacks(characterBlankFiller)
        mHandler.removeCallbacks(characterHtmlFiller)
        mHandler.postDelayed(characterHtmlFiller, mDelay)
    }
}
