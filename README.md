# SecondCallbackExample

This is second version of callbacks from this example

```java
    //Create interface and declare it
    private OnScoreSavedListener onScoreSavedListener;
    public interface OnScoreSavedListener {
        public void onScoreSaved();
    }
    
    //Alows you to set listener or invoke the overiding method from within activity
    public void setOnScoreSavedListener(OnScoreSavedListener listener) {
        onScoreSavedListener = listener;
    }
    
    //Call this in the right place
    onScoreSavedListener.onScoreSaved();
    
    //Declare in the activity
    MyCustomView slider = (MyCustomView) view.findViewById(R.id.slider)
    slider.setOnScoreSavedListener(new OnScoreSavedListener() {
        @Override
        public void onScoreSaved() {
            Log.v("","EVENT FIRED");
        }
    });
