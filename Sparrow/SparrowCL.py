import httplib2
from bs4 import BeautifulSoup, SoupStrainer
import re
import webbrowser
import keyboard
import time
import sys

http = httplib2.Http()
buttonFolder = 'C:\\Sparrow\\Buttons\\'

def getLink(url,selector,b=1):
    s,r = http.request(url)
    results = []
    a=0
    soup = BeautifulSoup(r,"html.parser",parse_only=SoupStrainer('a',href=True))
    for link in soup.find_all("a",href=True):
        if selector in link['href']:
            results.append(link['href'])
            a+=1
        if a == b:
            if b == 1:
                return results[0]
            else:
                return results
        else:
            pass
        
def makeSafeFilename(inputFilename):
    cleaned_up_filename = re.sub(r"[/\\:*?'<>|!]", '', inputFilename)
    ''.join(i for i in cleaned_up_filename if ord(i)<128)
    return cleaned_up_filename

def getMagnet(m):#takes the name of a movie
    try:
        movie = makeSafeFilename(m)
        PB = 'https://thepiratebay.org'
        site = PB + '/search/'
        if len(movie.split()) >1:
            for x in movie.split():
                if x != movie.split()[-1]:
                    site += x +'%20'
                else:
                    site += x
        else:
            site +=movie
        site += '/0/7/0'
        T = getLink(site,'/torrent/')
        newsite = PB + T
        return getLink(newsite,'magnet')
    except TypeError:
        if 'or' in movie.split():
            m=''
            for x in range(movie.split().index('or')):
                m+=movie.split()[x]
            return getMagnet(m)
        else:
            return None

def main(titles):#string list
    for x in titles:
        print("getting '"+x+"'...")
        try:
            magnet = getMagnet(x)
            webbrowser.open(magnet)
            time.sleep(2);
            keyboard.press_and_release('enter')
            keyboard.press_and_release('enter')
        except TypeError:
            print("incorrect title '" + x + "' moving on")
            pass

def getQuery():
    if not rep:
        query = raw_input("Movie Titles: ")
    else:
        query = raw_input("Any More? : ")
    if query=="no" or query=="exit":
        exit()
    titles = query.split(',');
    main(titles);

main(sys.argv[1:]);
