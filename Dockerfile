FROM centos:7
RUN yum install httpd -y
COPY index.html /var/www/html
COPY index.html /var
COPY index.html /home
RUN systemctl enable httpd
CMD ["httpd","-D","FOREGROUND"]
