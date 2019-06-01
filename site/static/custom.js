if (
    typeof window !== "undefined" &&
    "serviceWorker" in navigator
  ) {
       navigator.serviceWorker
       .register("/static/sw.js")
       .then(function(reg) {
         console.log("Service worker registered");
       })
       .catch(function(e) {
         console.error("Error during worker registration:", e);
       });
     }

WebFontConfig = {
      google: { families: [ 'Inconsolata','Prompt:300','Sarabun:100' ] }
};

(function() {
      var wf = document.createElement('script');
      wf.src = 'https://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
      wf.type = 'text/javascript';
      wf.async = 'true';
      var s = document.getElementsByTagName('script')[0];
      s.parentNode.insertBefore(wf, s);
  })();