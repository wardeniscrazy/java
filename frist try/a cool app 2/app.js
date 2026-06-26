const modal = document.getElementById('modal');
const openBtn = document.getElementById('openContact');
const closeBtn = document.getElementById('closeModal');
const cancelBtn = document.getElementById('cancelBtn');
const form = document.getElementById('contactForm');
const toast = document.getElementById('toast');
const toastSub = document.getElementById('toastSub');

document.getElementById('year').textContent = new Date().getFullYear();

function showModal(){ modal.classList.add('show'); }
function hideModal(){ modal.classList.remove('show'); }

openBtn?.addEventListener('click', (e)=>{ e.preventDefault(); showModal(); });
closeBtn?.addEventListener('click', hideModal);
cancelBtn?.addEventListener('click', hideModal);
modal?.addEventListener('click', (e)=>{ if(e.target === modal) hideModal(); });

form?.addEventListener('submit', (e)=>{
  e.preventDefault();
  const nameEl = document.getElementById('name');
  const name = (nameEl?.value || '').trim() || 'there';
  toastSub.textContent = `Thanks, ${name}! We will contact you shortly.`;
  toast.classList.add('show');
  hideModal();
  setTimeout(()=> toast.classList.remove('show'), 3600);
  form.reset();
});

// smooth-scroll for hash links
document.querySelectorAll('a[href^="#"]').forEach(a=>{
  a.addEventListener('click', (e)=>{
    const id = a.getAttribute('href');
    if(!id || id === '#') return;
    const el = document.querySelector(id);
    if(el){
      e.preventDefault();
      el.scrollIntoView({behavior:'smooth'});
    }
  });
});

