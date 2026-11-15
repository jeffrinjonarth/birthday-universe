(() => {
  const installButton = document.getElementById('install-btn');
  let installPrompt = null;

  // Register the service worker so the app can load again when offline.
  if ('serviceWorker' in navigator) {
    window.addEventListener('load', () => {
      navigator.serviceWorker.register('/sw.js').catch(error => {
        console.warn('Service worker registration failed:', error);
      });
    });
  }

  // Chromium browsers expose the native install prompt.
  window.addEventListener('beforeinstallprompt', event => {
    event.preventDefault();
    installPrompt = event;
    if (installButton) installButton.hidden = false;
  });

  installButton?.addEventListener('click', async () => {
    if (!installPrompt) return;
    installPrompt.prompt();
    await installPrompt.userChoice;
    installPrompt = null;
    installButton.hidden = true;
  });

  window.addEventListener('appinstalled', () => {
    if (installButton) installButton.hidden = true;
  });
})();
