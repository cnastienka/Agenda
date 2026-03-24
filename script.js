document.addEventListener("DOMContentLoaded", function() {
    
    // 1. Preloader Logic
    const preloader = document.getElementById('preloader');
    setTimeout(() => {
        preloader.classList.add('fade-out');
        // Remover del DOM despues de animar para no bloquear clics
        setTimeout(() => { preloader.style.display = 'none'; }, 1200);
    }, 1800); // 1.8s de pantalla de carga

    // 2. Custom Cursor Logic
    const cursorDot = document.getElementById('cursor-dot');
    const cursorOutline = document.getElementById('cursor-outline');
    const hoverTargets = document.querySelectorAll('.hover-target, a, button, input, select');

    window.addEventListener('mousemove', function(e) {
        const posX = e.clientX;
        const posY = e.clientY;
        
        // El punto sigue exactamente
        cursorDot.style.left = `${posX}px`;
        cursorDot.style.top = `${posY}px`;

        // El anillo sigue con un ligero delay (efecto smooth)
        cursorOutline.animate({
            left: `${posX}px`,
            top: `${posY}px`
        }, { duration: 500, fill: "forwards" });
    });

    hoverTargets.forEach(target => {
        target.addEventListener('mouseenter', () => {
            cursorOutline.classList.add('hover-active');
            cursorDot.style.backgroundColor = 'transparent';
        });
        target.addEventListener('mouseleave', () => {
            cursorOutline.classList.remove('hover-active');
            cursorDot.style.backgroundColor = 'var(--hs-copper)';
        });
    });

    // 3. Nav scroll
    window.addEventListener('scroll', function() {
        const navbar = document.querySelector('.navbar-hs');
        if (window.scrollY > 50) {
            navbar.classList.add('scrolled');
        } else {
            navbar.classList.remove('scrolled');
        }
    });

    // 4. Scroll Reveal
    const reveals = document.querySelectorAll(".reveal-up");
    const revealOptions = { threshold: 0.15, rootMargin: "0px 0px -50px 0px" };

    const revealOnScroll = new IntersectionObserver(function(entries, observer) {
        entries.forEach(entry => {
            if (!entry.isIntersecting) return;
            entry.target.classList.add("active");
            observer.unobserve(entry.target); 
        });
    }, revealOptions);

    reveals.forEach(reveal => revealOnScroll.observe(reveal));
    
    // 5. Init Carousel
    const myCarouselElement = document.querySelector('#boutiqueRotator')
    const carousel = new bootstrap.Carousel(myCarouselElement, {
        interval: 4500,
        wrap: true
    })
});























// === Lógica del Newsletter ===
    const btnSuscribir = document.getElementById('btnSuscribir');
    if(btnSuscribir) {
        btnSuscribir.addEventListener('click', function() {
            const input = document.getElementById('nlEmailInput');

            if (!input.value) {
                input.style.borderColor = 'var(--hs-bronze)';
                input.placeholder = 'Requerido: Ingrese su correo';
                setTimeout(() => {
                    input.style.borderColor = '';
                    input.placeholder = 'tu@familyoffice.com';
                }, 2500);
                return;
            }

            this.textContent = 'Aprobado';
            this.style.background = 'var(--hs-copper)';
            this.style.borderColor = 'var(--hs-copper)';
            this.style.color = 'var(--hs-carbon)';
            input.value = '';
            input.placeholder = 'Encriptando...';

            setTimeout(() => {
                this.textContent = 'Suscribir';
                this.style.background = 'var(--hs-carbon)';
                this.style.borderColor = 'var(--hs-carbon)';
                this.style.color = 'var(--hs-pure-white)';
                input.placeholder = 'tu@familyoffice.com';
            }, 3000);
        });
    }