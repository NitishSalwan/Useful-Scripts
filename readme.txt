monitor_p_mail.pl Usage:

Syntax : scriptname  latency Target_Serveraddress Time_to_ping Your_emailid

Example :

./monitor_p_mail.pl ".5" "10.110.45.1" 10 abc@gmail.com

Description : This script can be used to check the inconsistency of ping latency.

If ping latency is greater than a given limit then this script is used to send an email at given address which notifies the number of voilations(latency greater than limit) within a given ping time period.
