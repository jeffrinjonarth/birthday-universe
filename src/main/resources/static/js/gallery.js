// Gentle reveal effects and click-to-expand photo viewing.
(() => {
 const items=document.querySelectorAll('.photo-card,.timeline-card,.section-heading,.wish-form');
 if('IntersectionObserver' in window){const io=new IntersectionObserver(entries=>entries.forEach(e=>{if(e.isIntersecting){e.target.animate([{opacity:0,transform:'translateY(24px)'},{opacity:1,transform:'translateY(0)'}],{duration:750,easing:'cubic-bezier(.2,.7,.2,1)',fill:'both'});io.unobserve(e.target)}}),{threshold:.12});items.forEach(el=>io.observe(el));}
 document.querySelectorAll('.photo-card img').forEach(img=>img.addEventListener('click',()=>{const overlay=document.createElement('div');overlay.style.cssText='position:fixed;inset:0;background:#05030bee;z-index:50;display:grid;place-items:center;padding:5vw;cursor:zoom-out';const large=document.createElement('img');large.src=img.src;large.alt=img.alt;large.style.cssText='max-width:90vw;max-height:88vh;object-fit:contain;border:1px solid #d9b56b55';overlay.append(large);overlay.addEventListener('click',()=>overlay.remove());document.body.append(overlay)}));
})();
