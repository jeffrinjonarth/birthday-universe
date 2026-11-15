// Lightweight ambient starfield. Pauses when the tab is hidden and respects reduced motion.
(() => {
  const canvas=document.getElementById('universe-canvas'); if(!canvas)return;
  const ctx=canvas.getContext('2d'); const reduced=matchMedia('(prefers-reduced-motion: reduce)').matches;
  let w=0,h=0,stars=[],raf=0;
  function resize(){w=canvas.width=innerWidth*devicePixelRatio;h=canvas.height=innerHeight*devicePixelRatio;canvas.style.width=innerWidth+'px';canvas.style.height=innerHeight+'px';stars=Array.from({length:Math.min(110,Math.floor(innerWidth/10))},()=>({x:Math.random()*w,y:Math.random()*h,r:Math.random()*1.5+.3,a:Math.random()*.6+.15,s:Math.random()*.18+.04}));}
  function draw(){ctx.clearRect(0,0,w,h);for(const p of stars){p.a+=Math.sin(Date.now()/1300+p.x)*.0015;ctx.fillStyle=`rgba(236,211,166,${Math.max(.08,Math.min(.8,p.a))})`;ctx.beginPath();ctx.arc(p.x,p.y,p.r*devicePixelRatio,0,Math.PI*2);ctx.fill();if(!reduced){p.y-=p.s*devicePixelRatio;if(p.y<0)p.y=h;}}if(!reduced)raf=requestAnimationFrame(draw);}
  resize();draw();addEventListener('resize',()=>{cancelAnimationFrame(raf);resize();draw()});document.addEventListener('visibilitychange',()=>{if(document.hidden)cancelAnimationFrame(raf);else if(!reduced)draw()});
  window.BirthdayFX={burst(x=innerWidth/2,y=innerHeight/2){const bits=[];for(let i=0;i<95;i++)bits.push({x,y,vx:(Math.random()-.5)*8,vy:(Math.random()-.65)*8,life:65+Math.random()*35,r:1+Math.random()*2});let frame=0;function step(){ctx.save();for(const p of bits){p.x+=p.vx;p.y+=p.vy;p.vy+=.08;p.life--;ctx.globalAlpha=Math.max(0,p.life/90);ctx.fillStyle=['#f3d69a','#e6a8cb','#fff3d4','#bd9ad6'][Math.floor(Math.random()*4)];ctx.beginPath();ctx.arc(p.x*devicePixelRatio,p.y*devicePixelRatio,p.r*devicePixelRatio,0,Math.PI*2);ctx.fill();}ctx.restore();if(frame++<95)requestAnimationFrame(step);}step();}};
})();
