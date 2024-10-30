def vulnerability(String imageName) {
    sh  ''' 
        trivy image siddharth67/solar-system:$GIT_COMMIT \
        --severity CRITICAL \
        --exit-code 1 \
        --format json -o trivy-image-CRITICAL-results.json
    '''
}

def reportConverter() {
    sh ''' trivy convert \
            --format template --template "@/usr/local/share/trivy/templates/html.tpl" \
            --output trivy-image-CRITICAL-results.html trivy-image-CRITICAL-results.json
        '''
}
