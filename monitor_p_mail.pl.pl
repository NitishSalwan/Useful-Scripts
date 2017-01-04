#!/usr/bin/perl -w
 
$latency = $ARGV[0];
print "latency....$latency \n";
 
$ip = $ARGV[1];
print "ip to ping.... $ip \n";
 
$time_to_ping = $ARGV[2];
print "time to ping.... $time_to_ping\n\n";
 
$email_to = $ARGV[3];
print "email TO........ $email_to\n\n";
 
$ping=`ping -w $time_to_ping  $ip`;
print "ping command... $ping\n\n";
 
$counter=0;
@lines=split /\n/ , $ping;
foreach $line (@lines)
{
 print "line.... $line \n\n";
 
 @words=split /\s+/,$line;
 if((exists $words[0]) && ($words[0] eq "64"))
 {
  foreach $word (@words)
  {
   #print "word....$word \n";
   if ( $word =~ /time/ )
   {
     @time1=split /=/ , $word;
     if($time1[1] > $latency)
     {
       $counter++;
       print "time..... $time1[1]";
     }
   }
  }
 }
}
 
print "total voilations....$counter";
 
 
#print @linesl.com';
$to = $email_to;
$from = 'Nitish.Salwan@xyz.com';
$subject = 'Server latency report';
$message = "there is an issue with servers
System detects with large ping time (more than $latency ) for IP: $ip ,more than $counter times in $time_to_ping seconds
";
 
 open(MAIL, "|/usr/sbin/sendmail -t");
 
  # Email Header
  print MAIL "To: $to\n";
  print MAIL "From: $from\n";
  print MAIL "Subject: $subject\n\n";
  # Email Body
  print MAIL $message;
 
  close(MAIL);
  print "Email Sent Successfully\n";;