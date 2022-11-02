const cacheName = "cache";
const precacheResources = [
"/",
"/js/main.js",
"/css/main.css",
"/img/icon/cate/1.png",
"/img/icon/cate/2.png",
"/img/icon/cate/3.png",
"/img/icon/cate/4.png",
"/img/icon/cate/5.png",
"/img/icon/cate/6.png",
"/img/icon/cate/7.png",
"/img/icon/cate/8.png",
"/img/icon/cate/9.png",
"/img/icon/cate/10.png",
"/img/icon/cate/11.png",
"/img/icon/cate/12.png",
"/img/icon/cate/13.png",
"/img/icon/cate/14.png",
"/img/icon/cate/15.png",
"/img/icon/cate/16.png",
"/img/icon/cate/17.png",
"/img/icon/cate/18.png",
"/img/icon/cate/19.png",
"/img/icon/layout/address.jpg",
"/img/icon/layout/logo.png",
"/img/icon/layout/review.jpg"
];

self.addEventListener("install", event => {
  console.log("Service worker install event!");
  event.waitUntil(
    caches.open(cacheName).then(cache => {
      return cache.addAll(precacheResources);
    })
  );
});

self.addEventListener("activate", () => {
  console.log("Service worker activate event!");
});

self.addEventListener("fetch", event => {
  console.log("Fetch intercepted for:", event.request.url);
  event.respondWith(
    caches.match(event.request).then(cachedResponse => {
      if (cachedResponse) {
        return cachedResponse;
      }
      return fetch(event.request);
    })
  );
});