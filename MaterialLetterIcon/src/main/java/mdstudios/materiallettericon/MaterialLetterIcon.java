package mdstudios.materiallettericon;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MaterialLetterIcon extends FrameLayout {

    private View mView;
    private TextView mLetter;

    public MaterialLetterIcon(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public MaterialLetterIcon(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MaterialLetterIcon(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public MaterialLetterIcon(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        onInflated(inflate(context, R.layout.material_letter, this));

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.MaterialLetterIcon,
                    0, 0);

            try {
                mLetter.setText(a.getText(0));
            } finally {
                a.recycle();
            }
        }
    }

    private void onInflated(View view) {
        mView = view.findViewById(R.id.background);
        mLetter = findViewById(R.id.letter);
    }

    public void setLetter(String letter) {
        String s = letter.length() == 1 ? letter : letter.substring(0, 1);
        mLetter.setText(s);
    }

    public void setLetterSize(int size) {
        mLetter.setTextSize((float) size);
    }

    public void setBackgroundColour(int resID) {
        mView.getBackground().setTint(resID);
    }

    public void setLetterColour(int resID) {
        mLetter.setTextColor(resID);
    }
}
