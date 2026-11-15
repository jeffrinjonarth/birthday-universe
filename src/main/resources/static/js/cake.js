(() => {
 const btn=document.getElementById('wish-btn'),cake=document.querySelector('.cake'),msg=document.getElementById('wish-message');if(!btn)return;
 btn.addEventListener('click',()=>{cake.classList.add('blown');msg.classList.add('show');btn.textContent='A wish sent to the universe ✨';window.BirthdayFX?.burst();setTimeout(()=>window.BirthdayFX?.burst(innerWidth*.3,innerHeight*.35),350);setTimeout(()=>window.BirthdayFX?.burst(innerWidth*.7,innerHeight*.3),700);});
})();
